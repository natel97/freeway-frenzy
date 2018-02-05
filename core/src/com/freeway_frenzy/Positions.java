package com.freeway_frenzy;

public class Positions {

	public enum Sidewalks {
		SIDEWALK1(64), SIDEWALK2(576), SIDEWALK3(1344), SIDEWALK4(1856);
		public final int x;

		Sidewalks(int x) {
			this.x = x;
		}
	}

	public enum Lanes {
		LANE1(224), LANE2(416), LANE3(1504), LANE4(1664);
		public final int x;

		Lanes(int x){
			this.x = x;
		}
	}
}
