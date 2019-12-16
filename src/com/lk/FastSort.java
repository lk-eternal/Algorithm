package com.lk;

import java.util.Arrays;
import java.util.Random;

/**
 * @クラス名： FastSort
 * @説明：
 * @作成者： サンゾーン）李
 * @作成日： 2018/05/31
 * @更新着：
 * @最後更新日：
 */
public class FastSort {
	public static void main(String[] args) {
		int data[]=new int[10];

		Random r=new Random();
		for (int i = 0; i < data.length; i++) {
			data[i]=r.nextInt(50);
			System.out.print(data[i]+",");
		}
		System.out.println();

		System.out.println("-----------sort------------");
		sort(data,0,9);
		print(data);
	}

	public static void sort(int[] data ,int left,int right){
		if(left>=right){
			return;
		}
		int pr=data[left];
		int r = right;
		int l = left;//挖坑
		for (; l < r; r--) {//从右往左找
			if(data[r]<pr){//命中小于
				data[l]=data[r];
				for (; l < r; l++) {//从左往右找
					if(data[l]>pr){//命中大于,交换
						data[r]=data[l];
						print(data);
						break;
					}
				}
				if(l==r){//相遇,跳出
					break;
				}
			}
		}
		//交换基数
		data[r]=pr;
		print(data);
		sort(data,left,r-1);
		sort(data,r+1,right);
	}

	public static void print(int[] data){
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+",");
		}
		System.out.println();
	}
}