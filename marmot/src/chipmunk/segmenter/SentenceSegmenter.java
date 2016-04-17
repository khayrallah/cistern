package chipmunk.segmenter;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

import marmot.util.FileUtils;

import chipmunk.segmenter.Word;


public abstract class SentenceSegmenter implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract SegmentationReading segment(Word word);

	public void segmentToFile(String outfile, Iterable<Word> words) throws IOException {
		Writer writer = FileUtils.openFileWriter(outfile);
		boolean first = true;
		for (Word word : words) {
		    	if (word.getWord().equals("*END*")){
				writer.write('\n');
				first = true;
			}else{
				if (first){ 
					first = false;
				}else{
					writer.write(' ');
				}
	  		      	SegmentationReading reading = segment(word);
				writer.write(reading.toString());
			}
		}
		writer.close();
	}

}
