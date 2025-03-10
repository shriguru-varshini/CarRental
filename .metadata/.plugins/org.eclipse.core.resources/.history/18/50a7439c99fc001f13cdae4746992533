import { useEffect, useState } from "react";
import reservationService from "../../service/reservationService";

const UpdateReservation = ({carId, userId, reservationId }) => {
  const [reservation, setReservation] = useState(null);
  const [startDatetime, setStartDatetime] = useState("");
  const [endDatetime, setEndDatetime] = useState("");
  const [loading, setLoading] = useState(true);
  const [message, setMessage] = useState("");

  useEffect(() => {
    const fetchReservation = async () => {
      try {
        const data = await reservationService.getReservationById(reservationId);
        if (data) {
          setReservation(data);
          setStartDatetime(data.startDatetime);
          setEndDatetime(data.endDatetime);
        }
      } catch (error) {
        setMessage("Failed to fetch reservation details.");
      } finally {
        setLoading(false);
      }
    };

    fetchReservation();
  }, [reservationId]);

  const handleUpdate = async () => {
    try {
      const updatedData = { startDatetime, endDatetime };
      await reservationService.updateReservation(reservationId,userId, carId, updatedData);
      setMessage("Reservation updated successfully.");
    } catch (error) {
      setMessage("Failed to update reservation.");
    }
  };

  if (loading) return <p>Loading reservation details...</p>;

  return (
    <div>
      <h3>Update Reservation</h3>

      <p><strong>User:</strong> {reservation?.user?.name}</p>
      <p><strong>Car:</strong> {reservation?.car?.brand} {reservation?.car?.model}</p>

      <label>Start Time:</label>
      <input
        type="datetime-local"
        value={startDatetime}
        onChange={(e) => setStartDatetime(e.target.value)}
      />
      <br />

      <label>End Time:</label>
      <input
        type="datetime-local"
        value={endDatetime}
        onChange={(e) => setEndDatetime(e.target.value)}
      />
      <br />

      <button onClick={handleUpdate}>Update</button>
      {message && <p>{message}</p>}
    </div>
  );
};

export default UpdateReservation;
