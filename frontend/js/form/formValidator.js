export function validateStepData(step, data) {
    const errors = [];
    switch (step) {
        case 1:
            if (!data.companyName?.trim()) errors.push('Company name is required.');
            if (!data.rfpDate) errors.push('RFP Date is required.');
            if (!data.endDate) errors.push('End Date is required.');
            if (!data.projectName?.trim()) errors.push('Project Name is required.');
            if (!data.projectGoal?.trim()) errors.push('Project Goal is required.');
            if (!data.technicalDescription?.trim()) errors.push('Technical Description is required.');
            if (!data.integrationPlan?.trim()) errors.push('Integration Plan is required.');
            if (!data.dataSecurity?.trim()) errors.push('Data Security is required.');
            // Regex validation for Total Price (must be a positive number)
            if (!data.totalPrice || isNaN(Number(data.totalPrice)) || Number(data.totalPrice) <= 0) {
                errors.push('Total Price must be a positive number.');
            }
            if (!data.supportWarranty?.trim()) errors.push('Support and Warranty is required.');
            break;
        case 2:
            if (!data.phaseName?.trim()) errors.push('Phase Name is required.');
            if (!data.startDate) errors.push('Start Date is required.');
            if (!data.phaseEndDate) errors.push('End Date is required.');
            if (!data.deliverables?.trim()) errors.push('Deliverables are required.');
            break;
        case 3:
            if (!data.companyCertifications?.trim()) {
                errors.push('Company Certifications are required.');
            } else if (!/^[a-zA-Z0-9, ]+$/.test(data.companyCertifications)) {
                errors.push('Company Certifications must be alphanumeric and separated by commas.');
            }
            break;
        case 4:
            if (!data.memberName?.trim()) errors.push('Member Name is required.');
            if (!data.role?.trim()) errors.push('Role is required.');
            if (!data.specialization?.trim()) errors.push('Specialization is required.');
            if (!data.teamFile) errors.push('Team file upload is required.');
            break;
        default:
            errors.push('Invalid step.');
    }
    if (errors.length > 0) {
        alert(errors.join('\n'));
    }
    return errors;
}











