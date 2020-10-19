/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author smprs
 */
public class Distances {
    
    int DistanceId;
    int FromBranchId;
    int ToBranchId;
    String Distance;

    public int getDistanceId() {
        return DistanceId;
    }

    public void setDistanceId(int DistanceId) {
        this.DistanceId = DistanceId;
    }

    public int getFromBranchId() {
        return FromBranchId;
    }

    public void setFromBranchId(int FromBranchId) {
        this.FromBranchId = FromBranchId;
    }

    public int getToBranchId() {
        return ToBranchId;
    }

    public void setToBranchId(int ToBranchId) {
        this.ToBranchId = ToBranchId;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String Distance) {
        this.Distance = Distance;
    }

    @Override
    public String toString() {
        return "Distances{" + "DistanceId=" + DistanceId + ", FromBranchId=" + FromBranchId + ", ToBranchId=" + ToBranchId + ", Distance=" + Distance + '}';
    }
    
}
