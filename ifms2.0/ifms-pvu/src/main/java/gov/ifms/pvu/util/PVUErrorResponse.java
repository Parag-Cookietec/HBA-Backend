package gov.ifms.pvu.util;
import gov.ifms.common.constant.MsgConstant;

public enum PVUErrorResponse {

    RECORD_NOT_FOUND(1000,MsgConstant.RECORD_NOT_FOUND);



      private final int code;
      private final String message;

      private PVUErrorResponse(int code, String description) {
        this.code = code;
        this.message = description;
      }

      public String getMessage() {
         return message;
      }

      public int getCode() {
         return code;
      }


      public String getMessage(String params) {
             return message+params;
          }

      @Override
      public String toString() {
        return code + ": " + message;
      }
    }
	

	