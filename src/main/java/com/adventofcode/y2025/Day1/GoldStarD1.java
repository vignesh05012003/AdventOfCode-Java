package com.adventofcode.y2025.Day1;


import java.util.List;

import com.adventofcode.helper.Filehelper;

public class GoldStarD1 
{
	public static int rt(int pos)
	{
		pos++;
		if(pos == 100)
		{
			pos = 0;
		}
		return pos;
	}
	public static int lt(int pos)
	{
		pos--;
		if(pos == -1)
		{
			pos = 99;
		}
		return pos;
	}
	
	public static long find(List<Integer> num)
	{
		long c =0;
		int pos = 50;
		for(int n : num)
		{
			for(int i =0 ;i< Math.abs(n);i++)
			{
				if(n<0)
				{
					pos = lt(pos);
				}
				else
				{
					pos = rt(pos);
				}
				if(pos==0)
				{
					c++;
				}
			}
		}
		return c;
	}
	public static void main(String[] args)
	{
		List<String> count = Filehelper.readFileFromResource("y2025/Day1.txt");
		List<Integer> num = count.stream().map(s -> {
			s = s.replace('L','-');
			s = s.replace('R','+');
			return s;
		}).map(Integer :: parseInt).toList();
		System.out.println(find(num));
	}
	

}
