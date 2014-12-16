 public  void insertionSort(){
	for(int i = 1; i < size(); i++){
	    String value = get(i);
	    int j = i - 1;
	    while(j >= 0 && get(j).compareTo(value) < 1){
		set(j + 1, get(j));
		j--;
	    }
	    set(j + 1, value);
	}
    }
    public void selectionSort(){
	for (int i = 0; i < size(); i++){
	    String temp = get(i);
	    for (int x = 1; x <   size(); x++){
		String smallest = get(0);
		if (smallest.compareTo(get(x)) > 0){
		    smallest = get(x);
		}
		set(i, smallest);
		set(x, temp);
	    }
	}
    }
