/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tvn.demoapp;

import com.tvn.pojo.Choice;
import com.tvn.services.QuestionServices;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DemoApp {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        QuestionServices s = new QuestionServices();
        s.getQuestions(2).forEach(q ->{
            try {
                System.out.println(q);
                
                List<Choice> choices = s.getChoices(q.getId());
                for (int i = 0; i < choices.size(); i++)
                    System.out.printf("%d. %s\n", i + 1, choices.get(i));
                
                System.out.println("Your answer: ");
                int idx = sc.nextByte();
                if (choices.get(idx - 1).isCorrect() == true)
                    System.out.println("EXACTLY!");
                else
                    System.out.println("WRONGLY!");
            }catch (SQLException ex){
                Logger.getLogger(DemoApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        });
    }
}
