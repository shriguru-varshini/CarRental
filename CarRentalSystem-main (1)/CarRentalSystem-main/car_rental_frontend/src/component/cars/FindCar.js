import { useEffect, useState } from "react";
import carService from "../../service/carService";

const FindCar = () => {
  const [cars, setCars] = useState([]);
  const [filters, setFilters] = useState({
    id: "",
    type: "",
    fuelType: "",
    transmission: "",
    seats: "",
  });

  useEffect(() => {
    const fetchCars = async () => {
      const data = await carService.getAllCars();
      if (data) setCars(data);
    };
    fetchCars();
  }, []);

  const handleFilterChange = (e) => {
    setFilters({ ...filters, [e.target.name]: e.target.value });
  };

  const filteredCars = cars.filter((car) => {
    return (
      (filters.id ? car.id.toString() === filters.id : true) &&
      (filters.type ? car.type === filters.type : true) &&
      (filters.fuelType ? car.fuelType === filters.fuelType : true) &&
      (filters.transmission ? car.transmission === filters.transmission : true) &&
      (filters.seats ? car.seats === parseInt(filters.seats) : true)
    );
  });

  return (
    <div>
      <h2>Find Your Car</h2>

      <div>
        <label>ID: </label>
        <input
          type="number"
          name="id"
          value={filters.id}
          onChange={handleFilterChange}
        />
      </div>

      <div>
        <label>Type: </label>
        <select name="type" onChange={handleFilterChange}>
          <option value="">All</option>
          <option value="Sedan">Sedan</option>
          <option value="SUV">SUV</option>
          <option value="TwoWheeler">Two-Wheeler</option>
          <option value="Convertible">Convertible</option>
          <option value="Truck">Truck</option>
        </select>
      </div>

      <div>
        <label>Fuel Type: </label>
        <select name="fuelType" onChange={handleFilterChange}>
          <option value="">All</option>
          <option value="Petrol">Petrol</option>
          <option value="Diesel">Diesel</option>
          <option value="Electric">Electric</option>
          <option value="Hybrid">Hybrid</option>
        </select>
      </div>

      <div>
        <label>Transmission: </label>
        <select name="transmission" onChange={handleFilterChange}>
          <option value="">All</option>
          <option value="Manual">Manual</option>
          <option value="Automatic">Automatic</option>
        </select>
      </div>

      <div>
        <label>Seats: </label>
        <input type="number" name="seats" onChange={handleFilterChange} />
      </div>

      <h3>Available Cars</h3>
      <ul>
        {filteredCars.length > 0 ? (
          filteredCars.map((car) => (
            <li key={car.id}>
              {car.brand} {car.model} - {car.type} ({car.fuelType}, {car.transmission})
            </li>
          ))
        ) : (
          <p>No cars match your criteria.</p>
        )}
      </ul>
    </div>
  );
};

export default FindCar;
