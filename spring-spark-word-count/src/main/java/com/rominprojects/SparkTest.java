package com.rominprojects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkTest {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("Test").setMaster("local[2]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> words = sc.parallelize(Arrays.asList("Romin", "Vaghani", "Romin"));
		Map<String, Long> wordCounts = words.countByValue();
		System.out.println("======Starting word count process========");
		wordCounts.forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println("======Completed word count process========");
		sc.close();
	}

}
