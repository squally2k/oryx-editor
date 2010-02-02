package de.hpi.bpmn2xpdl;

import org.json.JSONException;
import org.json.JSONObject;
import org.xmappr.Attribute;

public class XPDLTriggerTimer extends XMLConvertable {
	
	@Attribute("TimerCycle")
	protected String timerCycle;
	@Attribute("TimerDate")
	protected String timerDate;
	
	public String getTimerCycle() {
		return timerCycle;
	}
	
	public String getTimerDate() {
		return timerDate;
	}
	
	public void readJSONtimecycle(JSONObject modelElement) {
		setTimerCycle(modelElement.optString("timecycle"));
	}
	
	public void readJSONtimedate(JSONObject modelElement) {
		setTimerDate(modelElement.optString("timedate"));
	}
	
	public void setTimerCycle(String timerCycle) {
		this.timerCycle = timerCycle;
	}
	
	public void setTimerDate(String timerDate) {
		this.timerDate = timerDate;
	}
	
	public void writeJSONtimecycle(JSONObject modelElement) throws JSONException {
		putProperty(modelElement, "timecycle", getTimerCycle());
	}
	
	public void writeJSONtimedate(JSONObject modelElement) throws JSONException {
		putProperty(modelElement, "timedate", getTimerDate());
	}
	
	protected JSONObject getProperties(JSONObject modelElement) {
		return modelElement.optJSONObject("properties");
	}
	
	protected void initializeProperties(JSONObject modelElement) throws JSONException {
		JSONObject properties = modelElement.optJSONObject("properties");
		if (properties == null) {
			JSONObject newProperties = new JSONObject();
			modelElement.put("properties", newProperties);
			properties = newProperties;
		}
	}
	
	protected void putProperty(JSONObject modelElement, String key, String value) throws JSONException {
		initializeProperties(modelElement);
		
		getProperties(modelElement).put(key, value);
	}
}
