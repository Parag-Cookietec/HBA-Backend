package gov.ifms.edp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Instantiates a new velocity format utils.
 */
public class VelocityFormatUtils {

	private VelocityFormatUtils() {
	}

	/**
	 * Prints the.
	 *
	 * @param fileName the file fileName
	 * @param obj      the obj
	 */
	public static void print(String fileName, Object obj, Document document) throws IOException {
		StringWriter writer = getStringWriter(fileName, obj);
		parse(document, writer.toString());
	}

	public static void printMultiple(String fileName, Object obj, Document document) throws IOException {
		StringWriter writer = getStringWriter(fileName, obj);
		parseMultiple(document, writer.toString());
	}

	public static String printPDF(String fileName, Object obj) throws IOException, DocumentException {
		Document document = new Document();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, byteArrayOutputStream);
		print(fileName, obj, document);
		return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
	}

	public static String printPDFWithWaterMark(String fileName, Object obj, String watermark) throws IOException, DocumentException {
		Document document = new Document();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter pdfWriter = PdfWriter.getInstance(document, byteArrayOutputStream);
		pdfWriter.setPageEvent(new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
		print(fileName, obj, document);
		return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
	}

	private static StringWriter getStringWriter(String fileName, Object obj) {
		VelocityEngine velocityEngine = createEngine();
		Template t = createTemple(velocityEngine, fileName);
		VelocityContext context = new VelocityContext();
		context.put("data", obj);

		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		return writer;
	}

	/**
	 * Creates the temple.
	 *
	 * @param velocityEngine the velocity engine
	 * @param file           the file
	 * @return the template
	 */
	private static Template createTemple(VelocityEngine velocityEngine, String file) {
		return velocityEngine.getTemplate(file, "UTF-8");
	}

	/**
	 * Creates the engine.
	 *
	 * @return the velocity engine
	 */
	private static VelocityEngine createEngine() {
		VelocityEngine velocityEngine = new VelocityEngine();
		Properties p = new Properties();
		p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngine.init(p);
		return velocityEngine;
	}

	public static void parse(Document document, String html) throws IOException {
		document.open();
		HTMLWorker htmlWorker = new HTMLWorker(document);
		HashMap<String, Object> providers = new HashMap<>();
		htmlWorker.setProviders(providers);
		htmlWorker.parse(new StringReader(html));
		document.close();
	}

	public static void parseMultiple(Document document, String html) throws IOException {
		HTMLWorker htmlWorker = new HTMLWorker(document);
		HashMap<String, Object> providers = new HashMap<>();
		htmlWorker.setProviders(providers);
		htmlWorker.parse(new StringReader(html));
	}

	public static String printPDF(String fileName, Object obj,String watermark) throws IOException, DocumentException {
		Document document = new Document();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter pdfWriter=PdfWriter.getInstance(document, byteArrayOutputStream);
		pdfWriter.setPageEvent(
				new WatermarkPageEvent(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()), watermark));
		print(fileName, obj, document);
		return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
	}

}
