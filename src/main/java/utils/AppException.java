package utils;

/**
 * -------------------------------------------------------------------------------
 * CustomException
 * -------------------------------------------------------------------------------
 *
 * @author <AdityaPratama>
 * @version 0.1
 * <p>
 * -------------------------------------------------------------------------------
 * @since April 2019
 */

public class AppException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final String COMPANY_NAME = "-- ADIT : \n\n";
    private String exception;
    private String message;
    private String status;

    public AppException() {
        super();
        this.exception = "";
    }

    public AppException(String e) {
        super();
        this.exception = e;
    }

    public AppException(String status, String message) {
        this.message = COMPANY_NAME + "\n\n" + message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return this.exception;
    }

    public String getStatus() {
        return this.status;
    }

}
