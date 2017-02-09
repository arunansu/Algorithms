from numpy import exp, array, random, dot
class NeuralNetwork():
    def __init__(self):
        random.seed(1) #Seed random generator for consistency
        #We model a single nuron with 3 input connection and 1 output connection
        #assign random weights to a 3x1 matrix, with values randing from -1 to 1 and mean 0
        self.synaptic_weights = 2 * random.random((3, 1)) - 1
    #sigmoid function normalizes values to be between 0 and 1

    def __sigmoid(self, x):
        return 1 / (1 + exp(-x))

    def __sigmoid_derivative(self, x):
        return x * (1 - x)

    def predict(self, inputs):
        return self.__sigmoid(dot(inputs, self.synaptic_weights))

    def train(self, training_inputs, training_outputs, iterations):
        for iteration in range(iterations):
            output = self.predict(training_inputs)
            error = training_outputs - output
            adjustment = dot(training_inputs.T, error * self.__sigmoid_derivative(output))
            self.synaptic_weights += adjustment
            
if __name__ == '__main__':
    neural_network = NeuralNetwork()
    print("Random starting synaptic weight")
    print(neural_network.synaptic_weights)
    training_set_inputs = array([[0,0,1], [1,1,1], [1,0,1], [0,1,1]])
    training_set_outputs = array([[0,1,1,0]]).T
    neural_network.train(training_set_inputs, training_set_outputs, 10000)
    print("New synaptic weights after training")
    print(neural_network.synaptic_weights)
    print("Predicting")
    print(neural_network.predict(array([1,0,0])))