package de.grundid.fritz;

public class GuestAccessSettings {

	public enum Timeout {
		MIN_15(15), MIN_30(30), MIN_45(45), MIN_60(60), MIN_90(90);

		private int minutes;

		private Timeout(int minutes) {
			this.minutes = minutes;
		}

		public int getMinutes() {
			return minutes;
		}
	}

	private Timeout disableAfterTime;

	public Timeout getDisableAfterTime() {
		return disableAfterTime;
	}

	public void setDisableAfterTime(Timeout disableAfterTime) {
		this.disableAfterTime = disableAfterTime;
	}

	public boolean hasTimeout() {
		return disableAfterTime != null;
	}
}
