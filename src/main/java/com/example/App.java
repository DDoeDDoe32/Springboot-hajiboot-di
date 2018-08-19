package com.example;

import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan // @ComponentScan을 붙이면 이 클래스의 패키지 내부에 있는 모든 클래스를 검색합니다.
               // 대상 패키지를 변경하려면 basePackages속성에 패키지를 지정합니다.
public class App implements CommandLineRunner 
{
    @Autowired
    ArgumentResolver argumentResolver;
    @Autowired
    Calculator calculator;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Enter 2 numbers like 'a b' : ");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.getA(), argument.getB());
        System.out.println("result = " + result);
    }

    public static void main(String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
