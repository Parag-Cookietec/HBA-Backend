package gov.ifms.edp.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class WatermarkPageEvent extends PdfPageEventHelper {

    private static final Font CAT_FONT = new Font(Font.FontFamily.TIMES_ROMAN, 50, Font.NORMAL, BaseColor.LIGHT_GRAY);
    
    String date;
    String watermark;
    public WatermarkPageEvent(String date, String watermark) {
		super();
		this.date = date;
		this.watermark = watermark;
	}

	@Override
    public void onEndPage(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(writer.getDirectContentUnder(),
                Element.ALIGN_CENTER,  new Phrase(date + watermark, CAT_FONT),
                307.5f,370, 45f);
    }
}
