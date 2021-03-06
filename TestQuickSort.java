import java.util.ArrayList;

public class TestQuickSort
{
//testing the test for peak memory usage
	private static ArrayList<String> TestTestPeakUsage()
	{
		String n = "";
		ArrayList<String> arrOfProblems = new ArrayList<String>();
	//setup
		QuickSort s = new QuickSort();
		sortParams sP = new sortParams();
		sP.setMemUsage(64);
		s.initialize(sP);
		int memUsage1 = 96;
		int memUsage2 = 32;
	//experiment step 1
		s.TestPeakUsage(memUsage1);
	//testing case 1
		if(s.getSortParams().getMemUsage() != memUsage1)
		{
			n = "TestPeakUsage when greater";
			arrOfProblems.add(n);
		}
	//experiment step 2
		s.initialize(sP);
		s.TestPeakUsage(memUsage2);
	//testing case 2
		if(s.getSortParams().getMemUsage() != sP.getMemUsage())
		{
			n = "TestPeakUsage when less than";
			arrOfProblems.add(n);
		}
		return arrOfProblems;
	}
	
//testing the pivot value chooser
	private static String TestChoosePVal()
	{
		String n = "";
	//setup'
		QuickSort qSort = new QuickSort();
		int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3};
		int start = 0;
		int end = 8;
		int correctOutput = 2;
	//experiment step
		int PVal = qSort.choosePVal(arr, start, end);
	//testing
		if(PVal != correctOutput)
		{
			n = "Choose Pivot Value";
		}
		return n;
	}
		
//testing QuickSort
	private static ArrayList<String> TestQSortMethod()
	{
		String n = "";
		ArrayList<String> arrOfProblems = new ArrayList<String>();
	//setup
		QuickSort s = new QuickSort();
		int[] arrIN = {4, 7, 2, 0, 15, 200, 1, 37};
		int[] arrOUT = {0, 1, 2, 4, 7, 15, 37, 200};
		int[] arrIN2 = {4, 7, 9, 0, 12, 98, 1, 24};
		int[] arrOUT2 = {98, 24, 12, 9, 7, 4, 1, 0};
		sortParams sP = new sortParams();
		s.initialize(sP);
	//experiment step 1
		s.QSort(arrIN, 0, arrIN.length-1, Direction.ASCENDING, 0);
	//testing case 1
		for(int i=0; i<arrIN.length; i++)
		{
			if(arrIN[i] != arrOUT[i])
			{
				n = "Quick Sort Ascending";
				arrOfProblems.add(n);
			}
		}
	//experiment step 2
		s.QSort(arrIN2, 0, arrIN2.length-1, Direction.DESCENDING, 0);
	//testing case 2
		for(int i=0; i<arrIN2.length; i++)
		{
			if(arrIN2[i] != arrOUT2[i])
			{
				n = "Quick Sort Descending";
				arrOfProblems.add(n);
			}
		}
		return arrOfProblems;
	}
		
//testing the sort wrapper method
	private static ArrayList<String> TestSort()
	{
		String n = "";
		ArrayList<String> arrOfProblems = new ArrayList<String>();
	//setup
		Sort s = new QuickSort();
		sortParams sP = new sortParams();
		int[] arrIN = {7, 400, 207, 152, 671};
		int[] arrOUTas = {7, 152, 207, 400, 671};
		int[] arrOUTds = {671, 400, 207, 152, 7};
		sP.setArray(arrIN);
		sP.setStartIndex(0);
		sP.setEndIndex(arrIN.length);
		s.initialize(sP);
	//experiment step 1
		sP.setDirection(Direction.ASCENDING);
		s.sort(sP);
	//testing case 1
		for(int i=0; i<arrIN.length; i++)
		{
			if(s.getSortParams().getArray()[i] != arrOUTas[i])
			{
				n = "Quick Sort's Sort wrapper (Ascending)";
				arrOfProblems.add(n);
			}
		}
	//experiment step 2
		sP.setDirection(Direction.DESCENDING);
		s.sort(sP);
	//testing case 2
		for(int i=0; i<arrIN.length; i++)
		{
			if(s.getSortParams().getArray()[i] != arrOUTds[i])
			{
				n = "Quick Sort's Sort wrapper (Descending)";
				arrOfProblems.add(n);
			}
		}
		return arrOfProblems;
	}
		
	/*
	 * Runs all of the unit tests in this class
	 */
	public static void TestQSort()
	{
		ArrayList<String> whatTests = new ArrayList<String>();
		String Testname = "Quick Sort";
		String c = TestChoosePVal();
		if(!c.equals(""))
		{
			whatTests.add(c);
		}
		ArrayList<String> g = TestTestPeakUsage();
		ArrayList<String> g2 = TestQSortMethod();
		ArrayList<String> g3 = TestSort();
		if(!g.isEmpty())
		{
			for(int i=0; i<g.size(); i++)
			{
				if(!g.get(i).equals(""))
				{
					whatTests.add(g.get(i));
				}
			}
		}
		if(!g2.isEmpty())
		{
			for(int i=0; i<g2.size(); i++)
			{
				if(!g2.get(i).equals(""))
				{
					whatTests.add(g2.get(i));
				}
			}
		}
		if(!g3.isEmpty())
		{
			for(int i=0; i<g3.size(); i++)
			{
				if(!g3.get(i).equals(""))
				{
					whatTests.add(g3.get(i));
				}
			}
		}
		boolean isCorrect = testIfFalse(whatTests);
		FileIOUnitTestMenu.displayUnitTestResults(isCorrect, Testname, whatTests);
	}
		
	private static boolean testIfFalse(ArrayList<String> whatTests)
	{
		for(int i=0; i<whatTests.size(); i++)
		{
			if(!whatTests.get(i).equals(""))
			{
				return false;
			}
		}
		return true;
	}
}