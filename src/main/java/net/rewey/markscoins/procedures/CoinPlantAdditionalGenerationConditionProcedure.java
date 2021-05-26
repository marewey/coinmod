package net.rewey.markscoins.procedures;

import net.rewey.markscoins.MarkscoinsModElements;

import java.util.Map;

@MarkscoinsModElements.ModElement.Tag
public class CoinPlantAdditionalGenerationConditionProcedure extends MarkscoinsModElements.ModElement {
	public CoinPlantAdditionalGenerationConditionProcedure(MarkscoinsModElements instance) {
		super(instance, 80);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		double rando = 0;
		rando = (double) Math.random();
		if ((0.0075 >= (rando))) {
			return (true);
		}
		return (false);
	}
}
