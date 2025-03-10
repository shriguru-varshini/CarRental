import React, { useState } from "react";
import reservationService from "../../service/reservationService";

const DeleteReservation = () => {
  const [reservationId, setReservationId] = useState("");
  const [loading, setLoading] = useState(false);

  const handleCancel = async () => {
    if (!reservationId) {
      alert("Please enter a valid Reservation ID.");
      return;
    }

    const confirmCancel = window.confirm("Are you sure you want to cancel this reservation?");
    if (!confirmCancel) return;

    setLoading(true);
    try {
      await reservationService.cancelReservation(reservationId);
      alert("Reservation canceled successfully!");
      setReservationId("");
    } catch (error) {
      console.error("Error canceling reservation:", error.response?.data || error.message);
      alert("Failed to cancel reservation.");
    }
    setLoading(false);
  };

  return (
    <div>
      <h2>Cancel Reservation</h2>
      <label>Enter Reservation ID:</label>
      <input
        type="number"
        value={reservationId}
        onChange={(e) => setReservationId(e.target.value)}
        placeholder="Reservation ID"
        required
      />
      <button onClick={handleCancel} disabled={loading}>
        {loading ? "Cancelling..." : "Cancel Reservation"}
      </button>
    </div>
  );
};

export default DeleteReservation;
