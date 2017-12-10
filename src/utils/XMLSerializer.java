package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLSerializer implements Serializer {
	
	@SuppressWarnings("rawtypes")
	private Stack stack = new Stack();
	
	private File file;
	
	public XMLSerializer(File file)
	{
		this.file=file;
	}

	
	@SuppressWarnings("unchecked")
	public void push(Object o) {
		// TODO Auto-generated method stub
		stack.push(o);

	}

	
	public Object pop() {
		// TODO Auto-generated method stub
		return stack.pop();
	}

	
	public void write() throws Exception {
		// TODO Auto-generated method stub
		ObjectOutputStream os = null;
		
		try
		{
			XStream xstream = new XStream(new DomDriver());
			os=xstream.createObjectOutputStream(new FileWriter(file));
			os.writeObject(stack);
		}
		finally
		{
			if(os != null)
			{
				os.close();
			}
		}

	}

	
	@SuppressWarnings("rawtypes")
	public void read() throws Exception {
		// TODO Auto-generated method stub
		ObjectInputStream is = null;
		try {
			XStream xstream = new XStream(new DomDriver());
			is = xstream.createObjectInputStream(new FileReader(file));
			stack=  (Stack) is.readObject();
		}
		finally
		{
			if(is !=null)
			{
				is.close();
			}
		}

	}

}