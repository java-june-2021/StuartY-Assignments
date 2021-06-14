package com.codingdojo.phone;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ring() {
		String ringing = "Galaxy " + this.getVersion() + " says " + this.getRingtone();
		return ringing;
	}

	@Override
	public String unlock() {
		return "Unlocking via finger print";
	}

	@Override
	public void displayInfo() {
		System.out.println("Galaxy " + this.getVersion() + " from " + this.getCarrier());

	}

}
