package chipmunk.segmenter;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import marmot.util.FileUtils;

public class SentenceeStemmer extends Stemmer{
	
	
	public Stemmer(Segmenter segmenter, Mode mode) {
		super(segmenter, mode)
	}
	
	@override
	public void stemToFile(String outfile, SegmentationDataReader words)
			throws IOException {
		Writer writer = FileUtils.openFileWriter(outfile);
		for (Word word : words) {
			String stem = stem(word);
			writer.write(stem);
			writer.write(' ');
		}
		writer.close();
	}

}
