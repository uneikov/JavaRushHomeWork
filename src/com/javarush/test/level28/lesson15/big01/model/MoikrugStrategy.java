package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by URAN on 05.07.2016.
 */
public class MoikrugStrategy implements Strategy {

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {

        List<Vacancy> vacancyList = new ArrayList<>();

        try {

            Document doc;

            for (int i = 0; true; i++) {

                doc = getDocument(searchString, i);

                if (doc == null) break;

                Elements vacancies = doc.getElementsByClass("job");

                if (vacancies.isEmpty()) break;

                for (Element element : vacancies) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setSiteName(doc.title());
                    vacancy.setTitle(element.getElementsByClass("title").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").select("a[href]").text());
                    String city =""; // это прикол
                    if (element.getElementsByClass("location").text() != null)
                        city = element.getElementsByClass("location").text();
                    vacancy.setCity(city);
                    vacancy.setUrl("https://moikrug.ru" + element.getElementsByTag("a").attr("href"));
                    vacancy.setSalary(element.getElementsByClass("count").text());
                    vacancyList.add(vacancy);
                }
            }
        }catch (IOException ex) {ex.printStackTrace();}

        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException
    {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .referrer("none")
                .get();
    }
}
