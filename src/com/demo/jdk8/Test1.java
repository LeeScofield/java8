package com.demo.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author lee
 * 2017-5-16
 */
public class Test1 {

	public static void main(String[] args) {
		swing_test();
		swing_lambda();
	}
	
	public static void swing_test(){
		JFrame jFrame = new JFrame();
		JButton jButton = new JButton("click me");
		
		//button 点击事件
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("click swing");
			}
		});
		
		jFrame.add(jButton);
		jFrame.pack();     			//按钮自适应
		jFrame.setVisible(true);    //按钮可见性
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击右上角关闭时关闭程序
	}
	
	public static void swing_lambda(){
		JFrame jFrame = new JFrame();
		JButton jButton = new JButton("click me");
		
		//button 点击事件
		jButton.addActionListener(event -> System.out.println("click lambda"));
		
		jFrame.add(jButton);
		jFrame.pack();     			//按钮自适应
		jFrame.setVisible(true);    //按钮可见性
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击右上角关闭时关闭程序
	}
	
}
