package chipmunk.segmenter;

import java.io.IOException;
import java.io.Writer;

import marmot.util.FileUtils;

public class SentenceeStemmer extends Stemmer{
	
	
	public Stemmer(Segmenter segmenter, Mode mode) {
		super(segmenter, mode)
	}
	
	@Override
	public void stemToFile(String outfile, SegmentationDataReader words)
			throws IOException {
		Writer writer = FileUtils.openFileWriter(outfile);
		for (Word word : words) {
			if (word == "*END*"){
				writer.write('\n');	
			}else{
			String stem = stem(word);
				writer.write(stem);
				writer.write(' ');
			}
		}
		writer.close();
	}

}