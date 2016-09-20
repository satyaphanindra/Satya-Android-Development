package com.assignment.quizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Random {

	List<String> answerList1 = new ArrayList<String>();
	List<String> answerList2 = new ArrayList<String>();
	List<String> answerList3 = new ArrayList<String>();
	List<String> answerList4 = new ArrayList<String>();
	List<String> answerList5 = new ArrayList<String>();
	List<String> answerList6 = new ArrayList<String>();
	List<String> answerList7 = new ArrayList<String>();
	List<String> answerList8 = new ArrayList<String>();
	List<String> answerList9 = new ArrayList<String>();
	List<String> answerList10 = new ArrayList<String>();

	Map<String, List> questionMap1 = new HashMap<String, List>();
	Map<String, List> questionMap2 = new HashMap<String, List>();
	Map<String, List> questionMap3 = new HashMap<String, List>();
	Map<String, List> questionMap4 = new HashMap<String, List>();
	Map<String, List> questionMap5 = new HashMap<String, List>();
	Map<String, List> questionMap6 = new HashMap<String, List>();
	Map<String, List> questionMap7 = new HashMap<String, List>();
	Map<String, List> questionMap8 = new HashMap<String, List>();
	Map<String, List> questionMap9 = new HashMap<String, List>();
	Map<String, List> questionMap10 = new HashMap<String, List>();
	
	Map<String, String> answerMap1 = new HashMap<String, String>();
	Map<String, String> answerMap2 = new HashMap<String, String>();
	Map<String, String> answerMap3 = new HashMap<String, String>();
	Map<String, String> answerMap4 = new HashMap<String, String>();
	Map<String, String> answerMap5 = new HashMap<String, String>();
	Map<String, String> answerMap6 = new HashMap<String, String>();
	Map<String, String> answerMap7 = new HashMap<String, String>();
	Map<String, String> answerMap8 = new HashMap<String, String>();
	Map<String, String> answerMap9 = new HashMap<String, String>();
	Map<String, String> answerMap10 = new HashMap<String, String>();



	Map<Map<String, String>,Map<String, List>> keyMap = new HashMap<Map<String, String>, Map<String,List>>();


	List<Question> questionList = new ArrayList<Question>();

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public Random() {

		answerList1.add("Canada");
		answerList1.add("West Africa");
		answerList1.add("Australia");
		answerList1.add("North America");

		answerList2.add("Taiga");
		answerList2.add("Savannah");
		answerList2.add("Pampas");
		answerList2.add("Prairies");

		answerList3.add("ionosphere");
		answerList3.add("exosphere");
		answerList3.add("stratosphere");
		answerList3.add("troposphere");

		answerList4.add("temperature");
		answerList4.add("location");
		answerList4.add("weather");
		answerList4.add("All of the above");

		answerList5.add("mountain glaciers");
		answerList5.add("alpine glaciers");
		answerList5.add("continental glaciers");
		answerList5.add("piedmon glaciers");

		answerList6.add("mesosphere");
		answerList6.add("thermosphere");
		answerList6.add("thermosphere and exosphere");
		answerList6.add("thermosphere and mesosphere");

		answerList7.add("Middle East");
		answerList7.add("North Africa");
		answerList7.add("both (a) and (b)");
		answerList7.add("None of the above");

		answerList8.add("Basalt plateau");
		answerList8.add("Cinder cone");
		answerList8.add("Shield volcanoes");
		answerList8.add("Composite volcanoes");

		answerList9.add("Russia");
		answerList9.add("Vatican City");
		answerList9.add("Australia");
		answerList9.add("USA");

		answerList10.add("carbon dioxide");
		answerList10.add("water vapours");
		answerList10.add("water");
		answerList10.add("ozone");

		questionMap1.put("The great Victoria Desert is located in?", answerList1);
		questionMap2.put("The tropical grassland is?", answerList2);
		questionMap3.put("The temperature increases rapidly after?", answerList3);
		questionMap4.put("The humidity of the air depends upon?", answerList4);
		questionMap5.put("The largest glaciers are?", answerList5);
		questionMap6.put("The ionosphere includes?", answerList6);
		questionMap7.put("The largest dune files are found in?", answerList7);
		questionMap8.put("The least explosive volcano is?", answerList8);
		questionMap9.put("The largest country by area is?", answerList9);
		questionMap10.put("The infrared radiation are absorbed by?", answerList10);

		
		answerMap1.put("correctAnswer", "Australia");
		answerMap2.put("correctAnswer", "Savannah");
		answerMap3.put("correctAnswer", "ionosphere");
		answerMap4.put("correctAnswer", "All of the above");
		answerMap5.put("correctAnswer", "continental glaciers");
		answerMap6.put("correctAnswer", "thermosphere and exosphere");
		answerMap7.put("correctAnswer", "both (a) and (b)");
		answerMap8.put("correctAnswer", "Basalt plateau");
		answerMap9.put("correctAnswer", "Russia");
		answerMap10.put("correctAnswer", "carbon dioxide");
		
		
		keyMap.put(answerMap1, questionMap1);
		keyMap.put(answerMap2, questionMap2);
		keyMap.put(answerMap3, questionMap3);
		keyMap.put(answerMap4, questionMap4);
		keyMap.put(answerMap5, questionMap5);
		keyMap.put(answerMap6, questionMap6);
		keyMap.put(answerMap7, questionMap7);
		keyMap.put(answerMap8, questionMap8);
		keyMap.put(answerMap9, questionMap9);
		keyMap.put(answerMap10, questionMap10);

		
		List<Map.Entry<Map<String, String>, Map<String, List>>> list = new ArrayList<Map.Entry<Map<String, String>, Map<String, List>>>(
				keyMap.entrySet());
		Collections.shuffle(list);

		Question ramdomQuestion;

		for (Map.Entry<Map<String, String>, Map<String, List>> entry : list) {

			ramdomQuestion = new Question();

			System.out.println("id: " + entry.getKey());

			ramdomQuestion.setCorrectAnswer(entry.getKey().get("correctAnswer"));
			for (String question : keyMap.get(entry.getKey()).keySet()) {

				System.out.println("question: " + question);
				ramdomQuestion.setQuestion(question);

				List<String> options = new ArrayList<String>();

				for (Object option : keyMap.get(entry.getKey()).get(question)) {
					System.out.println("option: " + option);
					options.add(option.toString());
				}

				ramdomQuestion.setOptions(options);

			}
			
			questionList.add(ramdomQuestion);

		}
		
		setQuestionList(questionList);

	}

}
