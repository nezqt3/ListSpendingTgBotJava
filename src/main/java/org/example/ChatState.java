package org.example;

import org.telegram.telegrambots.meta.api.objects.Chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatState {

	public String state;
	public String data = null;

	public Map<String, List<Integer>> expenses = new HashMap<>();

	ChatState(String initialState) {
		state = initialState;
	}

	public String getFormattedCategories() {
		Set<String> categories = expenses.keySet();
		if (categories.isEmpty()) return "Категории отсутствуют";
		return String.join("\n", categories);
	}

	public String getFormattedExpenses() {
		if (expenses.isEmpty()) {
			return "Категории отсутствуют";
		}
		String formattedResult = "";
		for (Map.Entry<String, List<Integer>> category : expenses.entrySet()) {
			String categoryName = category.getKey();
			List<Integer> categoryExpenses = category.getValue();
			formattedResult += categoryName + ": " + getFormattedExpenses(categoryExpenses) + "\n";
		}
		return formattedResult;
	}

	private String getFormattedExpenses(List<Integer> expensesPerCategory) {
		String formattedResult = "";
		for (Integer expense : expensesPerCategory) {
			formattedResult += expense + " ";
		}
		return formattedResult;
	}

}
