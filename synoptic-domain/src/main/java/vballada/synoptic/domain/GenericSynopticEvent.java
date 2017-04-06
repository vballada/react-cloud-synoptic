package vballada.synoptic.domain;

/**
 * @author BALLADA_V
 *         <p>
 *         Some dummy implementation to start testing event sending
 *         </p>
 */
public class GenericSynopticEvent implements SynopticEvent {

	/**
	 * The message to send
	 */
	private String message;

	/**
	 * @param message
	 *            The message to send
	 */
	public GenericSynopticEvent(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
