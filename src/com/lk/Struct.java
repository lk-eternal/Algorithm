package com.lk;


/**
 * @クラス名： Struct
 * @説明：
 * @作成者： サンゾーン）李
 * @作成日： 2018/05/30
 * @更新着：
 * @最後更新日：
 */
public class Struct {

	static class List<T>{

		public static void main(String[] args) {
			List<String> myList=new List<String>();
			myList.add("123");
			myList.add("4345");
			myList.add("7");
			myList.add(null);
			myList.add("1456723");

			System.out.println(myList.get(2));

			System.out.println(myList.delete(2));
			System.out.println(myList.get(2));


			for (int i = 0; i < 651; i++) {
				myList.add(i+"d");
			}

			System.out.println(myList.contains("651d"));

			for (int i = 0; i < myList.size(); i++) {
				System.out.println(myList.get(i));
			}

			myList.clear();

			for (int i = 0; i < myList.size(); i++) {
				System.out.println(myList.get(i));
			}
		}

		private Object[] values;

		private int size;

		List(){
			values=new Object[10];
			size=0;
		}

		public void add(T t){
			if(size==values.length){
				Object[] newValues=new Object[values.length<<1];
				for(int i=0;i<size;i++){
					newValues[i]=values[i];
				}
				values=newValues;
			}
			values[size++]=t;
		}

		public T get(int index) throws RuntimeException{
			if(index<0||index>size){
				throw new RuntimeException("Out of area");
			}
			return (T)values[index];
		}

		public T delete(int index) throws RuntimeException{
			if(index<0||index>=size){
				throw new RuntimeException("Out of area");
			}
			T de=(T)values[index];
			for(int i=index;i<size-1;i++){
				values[index]=values[index+1];
			}
			size--;
			if(size<values.length/4){
				Object[] newValues=new Object[values.length/4];
				for(int i=0;i<size;i++){
					newValues[i]=values[i];
				}
				values=newValues;
			}
			return de;
		}

		public boolean contains(T t){
			if(t==null){
				for (int i = 0; i < size; i++) {
					if(values[i]==null){
						return  true;
					}
				}
			}else{
				for (int i = 0; i < size; i++) {
					if(t.equals(values[i])){
						return  true;
					}
				}
			}
			return false;
		}

		public void clear(){
			values=new Object[8];
			size=0;
		}

		public int size(){
			return size;
		}


	}

}