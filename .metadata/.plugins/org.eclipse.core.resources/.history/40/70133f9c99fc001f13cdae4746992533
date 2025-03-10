import React, { useState } from "react";
import reservationService from "../../service/reservationService";

const AddReservation = ({ userId, carId, totalPrice }) => {
  const [reservation, setReservation] = useState({
    startDatetime: "",
    endDatetime: "",
  });

  const handleChange = (e) => {
    setReservation({ ...reservation, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await reservationService.createReservation({
      userId,
      carId,
      startDatetime: reservation.startDatetime,
      endDatetime: reservation.endDatetime,
      totalPrice,
    });
  
    if (response) {
      alert("Reservation added successfully!");
      setReservation({ startDatetime: "", endDatetime: "" });
    } else {
      alert("Error adding reservation.");
    }
  };

  return (
    <div>
      <h2>Add Reservation</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="datetime-local"
          name="startDatetime"
          value={reservation.startDatetime}
          onChange={handleChange}
          required
        />
        <input
          type="datetime-local"
          name="endDatetime"
          value={reservation.endDatetime}
          onChange={handleChange}
          required
        />
        <button type="submit">Add Reservation</button>
      </form>
    </div>
  );
};

export default AddReservation;
