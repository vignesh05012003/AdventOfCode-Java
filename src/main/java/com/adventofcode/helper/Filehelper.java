package com.adventofcode.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filehelper 
{
	public static List<String> readFileFromResource(String fileName){
		URL resource = Filehelper.class.getClassLoader().getResource(fileName);
		List<String> lines = new ArrayList<>();
		if(resource == null)
		{
			throw new IllegalArgumentException("Resource not found" + fileName);
		}
		try
		{
			InputStream is = resource.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while((line = br.readLine()) != null)
			{
				lines.add(line);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return lines;
 		
	}
	
	public static Integer[][]  readfilefromResourceAsIntegers(String fileName, String deliminator)
	{
		return readFileFromResource(fileName).stream().map(s -> s.split(deliminator))
				.map(arr -> Arrays.stream(arr).map(Integer:: parseInt).toArray(Integer[][]::new))
				.toArray(Integer[][]::new);
		
	}
	
	public static char[][] readfilefromResourceAsChar(String fileName, String deliminator)
	{
		return readFileFromResource(fileName).stream().map(s -> s.split(deliminator))
				.map(arr -> Arrays.stream(arr).collect(Collectors.joining()).toCharArray())
				.toArray(char[][]::new);
	}
	

}
