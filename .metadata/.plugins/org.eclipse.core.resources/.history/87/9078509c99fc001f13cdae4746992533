import React, { useState } from 'react';
import userService from '../../service/userService';

const AddAdmin = () => {
    const [adminData, setAdminData] = useState({
        name: '',
        email: '',
        phone: '',
        password: '',
    });

    const [error, setError] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setAdminData({ ...adminData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        try {
            const response = await userService.addAdmin(adminData);
            if (response) {
                alert('Admin added successfully!');
                setAdminData({ name: '', email: '', phone: '', password: '' }); // Clear form
            } else {
                setError('Failed to add admin.');
            }
        } catch (err) {
            setError('Something went wrong. Please try again.');
            console.error('Error adding admin:', err);
        }
    };

    return (
        <div>
            <h2>Add Admin</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={adminData.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={adminData.email}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Phone:</label>
                    <input
                        type="text"
                        name="phone"
                        value={adminData.phone}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={adminData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                {error && <p style={{ color: 'red' }}>{error}</p>}
                <button type="submit">Add Admin</button>
            </form>
        </div>
    );
};

export default AddAdmin;
