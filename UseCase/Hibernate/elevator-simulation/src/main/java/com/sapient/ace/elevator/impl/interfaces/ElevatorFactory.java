package com.sapient.ace.elevator.impl.interfaces;

import com.sapient.ace.elevator.impl.enums.ElevatorDirection;
import com.sapient.ace.elevator.impl.enums.ElevatorStatus;

public interface ElevatorFactory {
  public void moveUp();
  public void moveDown();
  public void addNewDestinatoin(Integer destination);
  public ElevatorDirection direction();
  public ElevatorStatus status();

}
