import React, { useState } from "react";
import carService from "../../service/carService";

const DeleteCar = () => {
  const [carId, setCarId] = useState("");
  const [loading, setLoading] = useState(false);

  const handleDelete = async () => {
    if (!carId) {
      alert("Please enter a valid car ID.");
      return;
    }

    const confirmDelete = window.confirm("Are you sure you want to delete this car?");
    if (!confirmDelete) return;

    setLoading(true);
    try {
      await carService.deleteCar(carId);
      alert("Car deleted successfully!");
      setCarId("");
    } catch (error) {
      console.error("Error deleting car:", error.response?.data || error.message);
      alert("Failed to delete car.");
    }
    setLoading(false);
  };

  return (
    <div>
      <h2>Delete Car</h2>
      <label>Enter Car ID:</label>
      <input
        type="number"
        value={carId}
        onChange={(e) => setCarId(e.target.value)}
        placeholder="Car ID"
        required
      />
      <button onClick={handleDelete} disabled={loading}>
        {loading ? "Deleting..." : "Delete Car"}
      </button>
    </div>
  );
};

export default DeleteCar;
