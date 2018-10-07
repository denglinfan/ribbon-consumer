package com.charles.ribbonconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RibbonConsumerApplicationTests {

	@Test
	public void contextLoads() {
	}


	public static void main(String[] args){
		String path = System.getProperty("webapp.root");
		System.out.println(path);
		//executeCommand();
	}

	public static void executeCommand(){
		String command = "ls -l /charles/test";
		StringBuffer output = new StringBuffer();
		Process p;

		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while((line = reader.readLine()) != null){
				output.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e){
			e.printStackTrace();
		}

		System.out.println(output.toString());

	}

	public static void executeShell(){
		Process p;

		try {
			List<String> cmdList = new ArrayList<String>();
			cmdList.add("sh");
			cmdList.add("");//shell script filepath

			ProcessBuilder pb = new ProcessBuilder(cmdList);

			p = pb.start();
			p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
