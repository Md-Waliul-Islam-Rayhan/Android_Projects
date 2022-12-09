package com.company;

public class ThreadA extends Thread{
    public void run(){
        int i, num;
        String primeNumbers = "";

        for (i = 1; i <= 100000; i++)
        {
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                //Appended the Prime number to the String
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to 100000 are :");
        System.out.println(primeNumbers);

    }
}
