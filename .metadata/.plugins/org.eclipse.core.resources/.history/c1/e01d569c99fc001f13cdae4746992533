import React, { useEffect, useState } from 'react';
import userService from '../../service/userService';

const ShowCustomer = () => {
    const [admins, setAdmins] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchAdmins = async () => {
            try {
                const response = await userService.getUserByRole('admin');
                if (response) {
                    setAdmins(response);
                } else {
                    setError('Failed to fetch admins.');
                }
            } catch (err) {
                setError('Something went wrong. Please try again.');
                console.error('Error fetching admins:', err);
            }
        };

        fetchAdmins();
    }, []);

    return (
        <div>
            <h2>All Admins</h2>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            {admins.length > 0 ? (
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Created At</th>
                        </tr>
                    </thead>
                    <tbody>
                        {admins.map((admin) => (
                            <tr key={admin.id}>
                                <td>{admin.id}</td>
                                <td>{admin.name}</td>
                                <td>{admin.email}</td>
                                <td>{admin.phone}</td>
                                <td>{new Date(admin.createdAt).toLocaleString()}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            ) : (
                <p>No admins found.</p>
            )}
        </div>
    );
};

export default ShowCustomer;
