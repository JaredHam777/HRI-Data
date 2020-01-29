public enum Condition {
	AC("ARM CLOSE"), AF("ARM FAR"), RC("ARROW CLOSE"), RF("ARROW FAR");
	
	private String value;
	
	private Condition(String value) {		
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}