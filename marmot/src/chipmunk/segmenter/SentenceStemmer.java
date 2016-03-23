package chipmunk.segmenter;

import java.io.IOException;
import java.io.Writer;

import marmot.util.FileUtils;

public class SentenceeStemmer extends Stemmer{
	
	
	public Stemmer(Segmenter segmenter, Mode mode) {
		super(segmenter, mode);
	}
	
	@Override
	public void stemToFile(String outfile, SegmentationDataReader words)
			throws IOException {
		Writer writer = FileUtils.openFileWriter(outfile);
		boolean first = true;
		for (Word word : words) {
			if (word == "*END*"){
				writer.write('\n');
				first = true;
			}else{
			String stem = stem(word);
				if (first){ 
					first = false;
				}else{
					writer.write(' ');
				}
				writer.write(stem);
			}
		}
		writer.close();
	}

}
