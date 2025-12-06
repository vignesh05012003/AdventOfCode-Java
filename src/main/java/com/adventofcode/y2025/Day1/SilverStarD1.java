package com.adventofcode.y2025.Day1;

import java.util.ArrayList;
import java.util.List;

import com.adventofcode.helper.Filehelper;

public class SilverStarD1 
{
	public static void main(String[] args)
	{
		List<String> count = Filehelper.readFileFromResource("y2025/Day1.txt");
		List<Integer> num = new ArrayList<>();
		int c=0;
		for(String str : count)
		{
			num.add(Integer.parseInt(str.replace("L" ,"-").replace("R","")));
		}
		int dial = 50;
		for(int n:num) {
		int temp = dial - (n %100);
		if(temp < 0) //<
		{
			temp = 100 + temp;
			
		}
		if(temp >= 100)//>
		{
			temp %= 100; 
		}
		dial = temp;
		
		if(dial == 0 )
		{
			c++;
		}
		}
//		System.out.println(Integer.parseInt(count.get(2).replace("L" ,"-").replace("R","")));
//		System.out.println(count);
//		System.out.println(num);
		System.out.println(c);

	}

}
