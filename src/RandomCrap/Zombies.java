package RandomCrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Zombies {

		public static void main(String[]args){
		Brains(7);
		}
		
			public static void Brains(int n){
				int str = 0;
				int[] fightList = new int[n];
				fightList[0] = new Random().nextInt(100);
				int lowStr = fightList[0];
				for (int i = 1; i<fightList.length; i++){
					fightList[i]= new Random().nextInt(100);
					if(fightList[i] > str){
						str = fightList[i];
					}
					if(fightList[i]<lowStr){
						lowStr = fightList[i];
					}
					
				}System.out.println(Arrays.toString(fightList));
				System.out.println(str);
				System.out.println(lowStr);
			}
		}

