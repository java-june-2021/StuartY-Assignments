package com.codingdojo.phone;

public class IPhone extends Phone implements Ringable {

	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ring() {
		String ringer = "iPhone " + this.getVersion() + " says " + this.getRingtone();
		return ringer;
	}

	@Override
	public String unlock() {
		return "Unlocking via facial recognition";
	}

	@Override
	public void displayInfo() {
		System.out.println("iPhone " + this.getVersion() + " from " + this.getCarrier());

	}

}
