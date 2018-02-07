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

	public enum DestroyerPositions{
		A1(700, 100), A2(880, 100), A3(1060, 100), B1(700, 280), B2(880, 280), B3(1060, 280), C1(700, 460), C2(880, 460), C3(1060, 460), D1(700, 640), D2(880, 640), D3(1060, 640), E1(700, 820), E2(880, 820), E3(1060, 820);

		public final int x;
		public final int y;
		DestroyerPositions(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
