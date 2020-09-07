package vitals;

public class VitalsCheck {
	private IReporter reporter = new VitalReporterImpl();
	
	public boolean vitalsAreOk(int bpm, int spo2, int respRate) {
	    boolean isBpOk =  bpIsOk(bpm);
	    boolean isVitalOk = spo2IsOk(spo2);
	    boolean isRespRateOk = respRateIsOk(respRate);
	    System.out.println();
	     return isBpOk && isVitalOk && isRespRateOk;
	 }
	
	private boolean bpIsOk(int bpm) {
        if(bpm<70) {
            reporter.alert("BP", "Too Low");
            return false;
        }
        else if(bpm > 150) {
            reporter.alert("BP", "Too High");
            return false;
        } 
        reporter.alert("BP", "Normal");
        return true;    
    }
	private boolean spo2IsOk(int spo2) {
	    if(spo2<90) {
	        reporter.alert("spo2", "low");
	        return false;
	    } 
	    reporter.alert("spo2", "Normal");
	    return true;    
	}
	private boolean respRateIsOk(int respRate) {
	    if(respRate<30){
	    	reporter.alert("RespRate", "low");
	        return false;
	    }
	    else if(respRate > 95) {
	    	reporter.alert("RespRate", "High");
	        return false;
	    } 
	    reporter.alert("RespRate", "Normal");
	    return true;    
	}

}
