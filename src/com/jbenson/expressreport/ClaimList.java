package com.jbenson.expressreport;

import java.util.ArrayList;
import java.util.Collection;

import android.os.Parcel;
import android.os.Parcelable;


public class ClaimList implements Parcelable{
	
	protected ArrayList<Claim> claimList = new ArrayList<Claim>();
	
	public ClaimList() {
		claimList = new ArrayList<Claim>();	
	}


	public void addClaim(Claim testClaim) {
		claimList.add(testClaim);
	}

	
	public void removeClaim(Claim testClaim) {
		claimList.remove(testClaim);
	}

	public int size() {
		return claimList.size();
	}

	public boolean contains(Claim testClaim) {
		return claimList.contains(testClaim);
	}

	 protected ClaimList(Parcel in) {
	        if (in.readByte() == 0x01) {
	            claimList = new ArrayList<Claim>();
	            in.readList(claimList, Claim.class.getClassLoader());
	        } else {
	            claimList = null;
	        }
	    }

	    @Override
	    public int describeContents() {
	        return 0;
	    }

	    @Override
	    public void writeToParcel(Parcel dest, int flags) {
	        if (claimList == null) {
	            dest.writeByte((byte) (0x00));
	        } else {
	            dest.writeByte((byte) (0x01));
	            dest.writeList(claimList);
	        }
	    }

	    @SuppressWarnings("unused")
	    public static final Parcelable.Creator<ClaimList> CREATOR = new Parcelable.Creator<ClaimList>() {
	        @Override
	        public ClaimList createFromParcel(Parcel in) {
	            return new ClaimList(in);
	        }

	        @Override
	        public ClaimList[] newArray(int size) {
	            return new ClaimList[size];
	        }
	    };
}
