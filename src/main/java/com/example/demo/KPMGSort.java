package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class KPMGSort {

	@Data
	@AllArgsConstructor
	static class Student {
		public String name;
		public int score;
	}

	@Data
	@AllArgsConstructor
	static class Score {
		int count;
		int total;

		public void incrementCount() {
			this.count++;
		}

		public void addToTotal(int total) {
			this.total += total;
		}

		public double getAvg() {
			return count == 0 ? 0 : total / count;
		}

	}

	public static void main(String[] args) {
		List<Student> studentScores = new ArrayList<Student>() {
			{
				add(new Student("Faisal", 10));
				add(new Student("Faisal", 9));
				add(new Student("Faisal", 8));
				add(new Student("Faisal", 7));
				add(new Student("Faisal", 10));
				add(new Student("Anton", 9));
				add(new Student("Anton", 5));
				add(new Student("Anton", 15));
				add(new Student("Anton", 15));
				add(new Student("James", 15));
				add(new Student("James", 15));
				add(new Student("James", 25));

			}
		};
		log.debug("studentScores: {}", studentScores);

		Map<String, Score> scoreMap = new TreeMap<>();

		for (Student student : studentScores) {
			if (scoreMap.containsKey(student.name)) {
				scoreMap.computeIfPresent(student.name, (key, value) -> {
					value.incrementCount();
					value.addToTotal(student.getScore());
					return value;
				});
			} else {
				scoreMap.put(student.name, new Score(1, student.score));
			}
		}
		log.debug("scoreMap: {}", scoreMap);
		Set<Entry<String, Score>> set = scoreMap.entrySet();

		Map<String, Double> studentByAvgScoreMap = new TreeMap<>();
		for (Entry<String, Score> entry : scoreMap.entrySet()) {
			studentByAvgScoreMap.put(entry.getKey(), entry.getValue().getAvg());
		}

		log.debug("studentByAvgScoreMap: {}", studentByAvgScoreMap);

		studentByAvgScoreMap.entrySet().stream().sorted(Map.Entry.comparingByValue((a, b) -> b.compareTo(a)))
				.forEach(System.out::println);

	}

}
