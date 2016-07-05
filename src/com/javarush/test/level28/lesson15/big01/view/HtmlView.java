package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by URAN on 04.07.2016.
 */
public class HtmlView implements View {

    private Controller controller;

    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        String result = null;
        try {

            Document doc = getDocument();
            Element template = doc.getElementsByAttributeValue("class", "vacancy template").first();
            Element copy = template.clone();
            copy.removeAttr("style");
            copy.removeClass("template");
            doc.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : vacancies){
                Element newVacancy = copy.clone();
                newVacancy.getElementsByClass("city").first().text(vacancy.getCity());
                newVacancy.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                newVacancy.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = newVacancy.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                template.before(newVacancy.outerHtml());
            }

            result = doc.html();

        }catch (IOException ex) {
            ex.printStackTrace();
            return "Some exception occurred";
        }

        return result;
    }

    private void updateFile(String fileContent) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(fileContent);
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(List<Vacancy> vacancies) {

        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void setController(Controller controller) {

        this.controller = controller;

    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Новосибирск");
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
