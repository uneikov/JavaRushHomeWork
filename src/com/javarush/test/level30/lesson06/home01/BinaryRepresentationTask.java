package com.javarush.test.level30.lesson06.home01;

import java.util.Stack;
import java.util.concurrent.RecursiveTask;

/**
 * Created by URAN on 10.07.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {

    private  int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {

        String result = "";
        Stack<BinaryRepresentationTask> taskStack = new Stack<>();

        if (i > 0){
            result = String.valueOf(i % 2);
            BinaryRepresentationTask task = new BinaryRepresentationTask(i / 2);
            task.fork();
            taskStack.push(task);
        }
        // это единый блок, результат набирается на каждой итерации, начиная конца
        // поэтому result += taskStack.pop().join(); возвращает перевернутый результат
        while (!taskStack.empty()) result = taskStack.pop().join() + result;

        return result;
    }
}
