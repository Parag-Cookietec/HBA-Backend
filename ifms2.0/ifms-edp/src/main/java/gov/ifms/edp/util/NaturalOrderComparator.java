package gov.ifms.edp.util;

import java.util.Comparator;

import gov.ifms.edp.dto.ClueDto;


/**
 * A sorting comparator to sort strings numerically,
 * ie [1, 2, 10], as opposed to [1, 10, 2].
 */
public final class NaturalOrderComparator implements  Comparator<ClueDto> {

	    private final boolean caseInsensitive;

	    public NaturalOrderComparator(boolean caseInsensitive) {
	        this.caseInsensitive = caseInsensitive;
	    }

	    int compareRight(String a, String b) {
	        int bias = 0;
	        int ia = 0;
	        int ib = 0;

	        // The longest run of digits wins.  That aside, the greatest
	        // value wins, but we can't know that it will until we've scanned
	        // both numbers to know that they have the same magnitude, so we
	        // remember it in BIAS.
	        for (;; ia++, ib++) {
	            char ca = charAt(a, ia);
	            char cb = charAt(b, ib);

	            if (checkCharNotDigit(ca, cb)) {
	                return bias;
	            } else if (!Character.isDigit(ca)) {
	                return -1;
	            } else if (!Character.isDigit(cb)) {
	                return +1;
	            } else if (ca < cb) {
	                if (bias == 0) 
	                    bias = -1;
	            } else if (ca > cb) {
	                if (bias == 0)
	                    bias = +1;
	            } else if (checkCharisZero(ca, cb)) {
	                return bias;
	            }
	        }
	    }

		private boolean checkCharNotDigit(char ca, char cb) {
			return !Character.isDigit(ca) && !Character.isDigit(cb);
		}

	    public int compare(ClueDto o1, ClueDto o2) {
	    	 String a = o1.getName();
	         String b = o2.getName();

	        int ia = 0;
	        int ib = 0;
	        int nza = 0;
	        int nzb = 0;
	        char ca;
	        char cb;
	        int result;

	        while (true) {
	            // only count the number of zeroes leading the last number compared
	            nza = nzb = 0;
	            ca = charAt(a, ia);
	            cb = charAt(b, ib);

	            // skip over leading zeros
	      
	         checkca(cb,nzb,b,ib);
	         checkcb(cb,nzb,b,ib);

	            // process run of digits
	            result=checkDigitals(a, b, ia, ib, ca, cb);
	            if(result!=0) {
	            	return result;
	            }
	            if (checkCharisZero(ca, cb)) {
	                // The strings compare the same.  Perhaps the caller
	                // will want to call strcmp to break the tie.
	                return nza - nzb;
	            }
	            int charss=compairChar(ca, cb);
	            if(charss!=0) {
	            	return charss;
	            }

	            ++ia;
	            ++ib;
	        }
	    }

		private void checkca(char ca, int nza, String a, int ia) {
		      while (ca == '0') {
					if (ca == '0') { 
		                    nza++;
		                    }

		                // if the next character isn't a digit, then we've had a run of only zeros
		                // we still need to treat this as a 0 for comparison purposes
		                if (!Character.isDigit(charAt(a, ia+1)))
		                    break;

		                ca = charAt(a, ++ia);
		            }
		}

		private void checkcb(char cb,int nzb,String b,int ib) {
			   while (cb == '0') {
					 if (cb == '0') { 
		                    nzb++;
		                 }

		                // if the next character isn't a digit, then we've had a run of only zeros
		                // we still need to treat this as a 0 for comparison purposes
		                if (!Character.isDigit(charAt(b, ib+1)))
		                    break;

		                cb = charAt(b, ++ib);
		            }
			
		}

		private int compairChar(char ca, char cb) {
			if (ca < cb) {
			    return -1;
			} else if (ca > cb) {
			    return +1;
			}
			return 0;
		}

		private int checkDigitals(String a, String b, int ia, int ib, char ca, char cb) {
			int result=0;
			if (checkCharisDigit(ca, cb)) {
				 result=compareRight(a.substring(ia), b
			            .substring(ib));
			}
			 return result;
		}

		private boolean checkCharisZero(char ca, char cb) {
			return ca == 0 && cb == 0;
		}

		private boolean checkCharisDigit(char ca, char cb) {
			return Character.isDigit(ca) && Character.isDigit(cb);
		}

	    private char charAt(String s, int i) {
	        if (i >= s.length()) {
	            return 0;
	        } else {
	            return caseInsensitive ? Character.toUpperCase(s.charAt(i)) : s.charAt(i);
	        }
	    }


	}