package com.java.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ComparatorAndComparable {

    // Comparator's for the Customer Object using Inner Classes
    private static final class NameComparatorImplementation implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Customer1 obj1 = (Customer1) o1;
            Customer1 obj2 = (Customer1) o2;
            return obj1.getName().compareTo(obj2.getName());
        }
    }

    private static final class IdComparatorImplementation implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Customer1 obj1 = (Customer1) o1;
            Customer1 obj2 = (Customer1) o2;
            return (int) (obj1.getId() - obj2.getId());
        }
    }
    
    private static final class IdNameComparatorImplementation implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Customer1 obj1 = (Customer1) o1;
            Customer1 obj2 = (Customer1) o2;
            int value1 = (int) (obj1.getId() - obj2.getId());
            if (value1 == 0) {
                return obj1.getName().compareTo(obj2.getName());
            }
            return value1;
        }
    }

    public static void main(String[] args) {

        // Comparable interface check
        List<Customer1> listObj = new ArrayList<>();
        listObj.add(new Customer1(101, "Rajeev")); // adding duplicate rows
        listObj.add(new Customer1(101, "Rajeev"));
        listObj.add(new Customer1(102, "Sachin"));
        listObj.add(new Customer1(103, "Chris"));
        listObj.add(new Customer1(103, "Rajeev"));
        listObj.add(new Customer1(109, "Ritika"));
        listObj.add(new Customer1(101, "Rajeev"));

        Customer1 oo = new Customer1(103, "Chris");
        /* this returns true only if hashcode() and equals() are overriden in Bean 
         * (Because those two methods will does not allow duplicate values to generate 
         * due to same hashcode generation every time) 
         * */
        System.out.println("Exists: "+listObj.contains(oo)+", index: "+listObj.indexOf(oo));

        Collections.sort(listObj, new IdComparatorImplementation());
        System.out.println("ID Comparator: " + listObj);

        Collections.sort(listObj, new NameComparatorImplementation());
        System.out.println("Name Comparator: " + listObj);

        Collections.sort(listObj, new IdNameComparatorImplementation());
        System.out.println("Id and Name Comparator: " + listObj);

        Collections.sort(listObj); // using comparable which mean it need to be implemented in object bean
        System.out.println("ID Comparable: " + listObj);
        
        System.out.println(methodTest(listObj));
    }

	private static List<Customer1> methodTest(List<Customer1> listObj) {
		listObj.get(0).setName("ffffffffffffffffffffffffffffff");
		return listObj;
	}
}

class Customer1 implements Comparable<Customer1> {
    private long id;
    private String name;

    public Customer1(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    // Comparable for Customer Object. Here only one operation can be done(i,e id here)
    @Override
    public int compareTo(Customer1 o) {
        return (int) (this.getId() - o.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer1 other = (Customer1) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result; //can also be  return Objects.hash(id, name);
    }
}