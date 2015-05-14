using System.IO;
namespace RR{
public abstract class NetworkResponse {
	
	public MemoryStream dataStream { get; set; }
	public short response_id { get; set; }
	
	public abstract void parse();
	public abstract ExtendedEventArgs process();
}
}