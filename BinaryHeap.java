class BinaryHeap
{
	private int[] data;
	public int size;

	public BinaryHeap()
	{
		data = new int [10];
		size = 0;
	} //binary heap

	//swaps the two numbers
	void swap(int[] data, int current, int parent)
	{
		int t = data[current];
		data[current] = data[parent];
		data[parent] = t;
	} //swap

	//grows the array
	public void grow()
	{
		int[] biggerarray = new int[data.length * 2];
		for(int i = 0; i < data.length; i++)
			biggerarray[i] = data[i];
		data = biggerarray;
	} //grow

	public void add(int num)
	{
		if(size >= data.length)
		{
			grow();
		}
		data[size++] = num;
		int current = size - 1;
		int parent = (current - 1) / 2;

		while((data[current] < data[parent]) && current > 0)
		{
			swap(data, current, parent);
			current = parent;
			parent = (parent - 1) / 2;
		} //while

	} //add

	public int remove()
	{
		try
		{
			if(size == 0)
			{
				throw new Exception();
			}
		} //try

		catch(Exception e)
		{
			System.out.println();
		} //catch

		swap(data, 0, size - 1);
		--size;
		if(size > 0)
		{
			shiftdown(0);
		}
		return data[size];

	} //remove

	public void shiftdown(int num)
	{
		int parent = num;
		int lchild = 2 * parent + 1;
		int rchild = 2 * parent + 2;

		if(lchild >= size || rchild >= size)
			return;
		if(data[lchild] > data[rchild] && data[rchild] < data[parent])
		{
			swap(data, parent, rchild);
			shiftdown(rchild);
		}
		else if(data[rchild] > data[lchild] && data[lchild] < data[parent])
		{
			swap(data, parent, lchild);
			shiftdown(lchild);
		}

	} //shiftdown

}









